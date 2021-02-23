import React, { Component } from 'react'

class WaintingComponent extends Component {
  render() {
    return (
      <div>
          <br></br>
          <div className = "card col-md-6 offset-md-3">
              <h1 className = "text-center"> Loading animals informations</h1>
              <div className = "card-body">
                  <div className = "row">
                      <img className="card-img-top" src="https://imagine.bayard.io/unsafe/380x0/bayard-static/edition/couvertures/9791027606108/9791027606108.jpg" alt="Loading animals"/>
                  </div>
                  <br/><br/>
              </div>
          </div>
      </div>
    );
  }
}
export default WaintingComponent
