import {ref, readonly, reactive} from 'vue'

export function useInfo() {

    const info = ref('Dies ist eine Nachricht')
    
    function loescheInfo() {
        info.value = ''
      }
}