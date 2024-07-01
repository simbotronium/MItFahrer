import {computed, readonly, reactive} from 'vue'

export function useInfo() {

    const state = reactive({
      info: ""
    })
    
    function loescheInfo() {
        state.info = ''
      }

    function setzeInfo(msg: string) {
      state.info = msg
    }

    return {
      state: readonly(computed(() => state)),
      loescheInfo,
      setzeInfo
    }
}