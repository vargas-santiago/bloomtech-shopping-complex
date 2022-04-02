import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import SignUp from "./SignUp";
import Login from "./Login";
import AccountDetails from "./AccountDetails";
import Stores from "./Stores";
import EditAccount from "./EditAccount";


function App() {
  return (
    <div className="App">
      <BrowserRouter>
      <div className="header">
        <NavLink activeclassname="active" to="/SignUp">Sign Up</NavLink>
        <NavLink activeclassname="active" to="/Login">Login</NavLink>
        <NavLink activeclassname="active" to="/AccountDetails">Account</NavLink>
        <NavLink activeclassname="active" to="/EditAccount">Edit Account</NavLink>
        <NavLink activeclassname="active" to="/Stores">Stores</NavLink>
      </div>
        <div className="content">
            <Routes>
                <Route exact path='/' element={<SignUp/>} />
                <Route exact path='/SignUp' element={<SignUp/>} />
                <Route exact path='/Login' element={<Login/>} />
                <Route exact path='/AccountDetails' element={<AccountDetails/>} />
                <Route exact path='/EditAccount' element={<EditAccount/>} />
                <Route exact path='/Stores' element={<Stores/>} />
            </Routes>
        </div>
      </BrowserRouter>
    </div>
  );
}

export default App;
