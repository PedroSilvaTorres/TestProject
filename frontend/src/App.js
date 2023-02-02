import {BrowserRouter, Routes, Route} from 'react-router-dom'
import Dashboard from './Dashboard';

function App(){
  return(
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Dashboard/>}/>
          <Route path="/Search" element={<></>}/>
          <Route path="/Misc" element={<></>}/>
        </Routes>
      </BrowserRouter>
  )
}

export default App;