import { createGlobalState } from "react-hooks-global-state";

const { setGlobalState, useGlobalState} = createGlobalState({
    userid: 0
});

export { setGlobalState, useGlobalState};