import {computed, readonly, reactive} from 'vue'

export function useInfo() {

    const state = reactive({
      info: String('Dies ist eine Nachricht.')
    })
    
    function loescheInfo() {
        state.info = ''
      }

    function setzeInfo(msg: string) {
      state.info = msg
    }

    return {
      info: readonly(computed(() => state.info)),
      loescheInfo,
      setzeInfo
    }
}