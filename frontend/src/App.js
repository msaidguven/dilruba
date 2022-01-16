import './App.css';
import {BrowserRouter, Switch, Route, Redirect} from "react-router-dom";
import NavBar from './Components/NavBar/NavBar';
import Home from './Components/Home/Home';
import User from './Components/User/User';
import Auth from './Components/Auth/Auth';
import PostPage from './Pages/PostPage';
import Category from './Components/Category/Category';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <NavBar />
        <Switch>
          <Route exact path="/" component={Home}></Route>
          <Route exact path="/users/:userId" component={User}></Route>
          <Route exact path="/post/:postId" component={PostPage}></Route>
          <Route exact path="/kpss/:menuSeflink" component={Category}></Route>
          <Route exact path="/auth">
          {localStorage.getItem("currentUser") != null ? <Redirect to="/"/>: <Auth/>}
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;