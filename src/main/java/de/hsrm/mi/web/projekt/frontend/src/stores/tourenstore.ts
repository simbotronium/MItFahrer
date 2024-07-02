import { computed, reactive } from "vue"
import { defineStore } from "pinia"
import type { ITourDTD } from "./ITourDTD"
import { useInfo } from "@/composables/useInfo"
import { Client, type Message } from "@stomp/stompjs"
import type { IFrontendNachrichtEvent } from "@/services/IFrontendNachrichtEvent"

const { state, loescheInfo, setzeInfo } = useInfo();

export const useTourenStore = defineStore("tourenstore", () => {
    let stompClientActivated = false;
    const tourdata = reactive({
        tourliste: Array<ITourDTD>(),
        ok: false
    })

    
    async function updateTourListe() {
      console.log("updating tour list")
      try {
        const resp = await fetch('/api/tour', {
          method: 'GET'
        })
        if (!resp.ok) {
          throw new Error(resp.statusText)
        }
        const jsondata = await resp.json()
        tourdata.tourliste = jsondata
        tourdata.ok = true
      } catch (reason) {
        setzeInfo(`Fehler: ${reason}`)
        tourdata.ok = false
      }
    }

    function startTourLiveUpdate() {
      if (stompClientActivated) {
        return;
      }
      const wsurl = `ws://${window.location.host}/stompbroker`;
      const DEST = "/topic/tour";

      const stompclient = new Client({ brokerURL: wsurl });
      stompclient.onWebSocketError = (event) => { console.log("Web Socket Error", event) };
      stompclient.onStompError = (event) => { console.log("Stomp error", event) };

      stompclient.onConnect = (frame) => {

        console.log("connected")

        stompclient.subscribe(DEST, async (message) => {
          const event: IFrontendNachrichtEvent = JSON.parse(message.body);
          console.log("empfangen: ", JSON.stringify(event));
          if (event.eventTyp === "TOUR") {
            await updateTourListe();
          }
        });
      };

      stompclient.onDisconnect = () => {
        stompClientActivated = false;
        console.log("disconnect");
        setzeInfo("StompClient disconnected");
      };

      stompclient.activate();
      stompClientActivated = true;
    }

    /*
    function updateTourListe() {
      tourdata.tourliste = JSON.parse(`
        [
          {"id":102,"abfahrDateTime":"1010-11-22T10:01:00","preis":10,"plaetze":1,"buchungen":0,"startOrtName":"Wiesbaden","startOrtId":1,"zielOrtName":"Schöngleina","zielOrtId":2302,"anbieterName":"Joghurta Biffel","anbieterId":1,"distanz":263.90476912561047,"info":""},
          {"id":1,"abfahrDateTime":"2023-11-17T19:30:00","preis":5,"plaetze":3,"buchungen":0,"startOrtName":"Wiesbaden","startOrtId":1,"zielOrtName":"Taucha","zielOrtId":3,"anbieterName":"Senkel","anbieterId":1552,"distanz":333.2123954484251,"info":"Auf nach Taucha!"},
          {"id":252,"abfahrDateTime":"2024-05-10T16:27:00","preis":12,"plaetze":2,"buchungen":0,"startOrtName":"Wiesbaden","startOrtId":1,"zielOrtName":"Bochum","zielOrtId":603,"anbieterName":"Glogomir Elektro","anbieterId":1652,"distanz":173.29384069882823,"info":""},
          {"id":2,"abfahrDateTime":"2033-02-01T18:00:00","preis":17,"plaetze":3,"buchungen":0,"startOrtName":"Wiesbaden","startOrtId":1,"zielOrtName":"Clenze","zielOrtId":4,"anbieterName":"Joghurta Biffel","anbieterId":1,"distanz":369.6370869573237,"info":"Alle wollen nach Clenze - Du doch sicherlich auch! Oder nicht? Doch!"}
        ]
        `)
    }
        */

    return {
      tourdata: reactive({tourdata}),
      updateTourListe,
      startTourLiveUpdate
    }
})
