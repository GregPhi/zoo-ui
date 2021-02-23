import React, { Component } from 'react'

class HomeComponent extends Component {
  constructor(props) {
      super(props)

      this.state = {

      }
  }

  viewAnimal(){
      this.props.history.push(`/animals`);
  }

  viewInfo(){
      this.props.history.push(`/infos`);
  }


  render() {
    return (
      <div class="album py-5 bg-light">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div class="col">
              <div class="card shadow-sm">
                <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                  <image href="../public/animals.jpg" x="0" y="0" height="50px" width="50px"/>
                </svg>
                <div class="card-body">
                <p class="card-text">Zoo animals.</p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnimal()} className="btn btn-info">Display</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col">
              <div class="card shadow-sm">
              <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <image href="../public/information.jpg" x="0" y="0" height="50px" width="50px"/>
              </svg>
              <div class="card-body">
                <p class="card-text">Zoo Information.</p>
                <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button style={{marginLeft: "10px"}} onClick={ () => this.viewInfo()} className="btn btn-info">Display</button>
                </div>
                </div>
              </div>
            </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default HomeComponent
