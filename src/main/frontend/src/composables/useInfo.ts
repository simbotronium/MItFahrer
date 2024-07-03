import {computed, readonly, reactive} from 'vue'

const state = reactive({
  info: ""
})

export function useInfo() {
    
    function loescheInfo() {
        state.info = ''
      }

    function setzeInfo(msg: string) {
      console.log("setze info:\n " + msg)
      state.info = msg
    }

    return {
      state: readonly(computed(() => state)),
      loescheInfo,
      setzeInfo
    }
}