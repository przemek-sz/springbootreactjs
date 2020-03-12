import React from 'react';
import axios from 'axios';


class UsersList extends React.Component {

  state = {
    users: []
  }

  update() {
    let authorization = window.sessionStorage.getItem('AuthKey');

    axios({
      'method': 'get',
      'url': 'http://localhost:8080/api/user',
      'headers': {
        'Content-Type': 'application/json',
        authorization
      }
    })
      .then((response) => {
        this.setState({
          users: response.data
        })
      });

  }


  componentDidMount() {

    this.update();

  }
  handleClick = (id) => {
    let authorization = window.sessionStorage.getItem('AuthKey');

    axios({
      'method': 'delete',
      'url': 'http://localhost:8080/api/user/' + id,
      'headers': {
        'Content-Type': 'application/json',
        authorization
      }
    })
      .then((response) => {
        this.update();
      })
  }

  render() {
    const { users } = this.state
    const usersList = users.length ? (
      users.map(user => {
        return (
          <div>
            <label>Username: </label>{user.username}
            <label> Email: </label>{user.email}
            <button onClick={() => this.handleClick(user.id)}> Delete</button>
          </div>
        )
      })
    ) : (
        <div className="center">No data</div>
      );

    return (
      <div>
        {usersList}
      </div>
    )
  }
}


export default UsersList;