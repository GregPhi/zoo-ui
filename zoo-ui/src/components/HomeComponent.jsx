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
      <div className="album py-5 bg-light">
        <div className="container">
          <div className="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div className="col">
              <div className="card shadow-sm">
                <svg className="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                  <image href="../public/animals.png" x="0" y="0" height="50px" width="50px"/>
                </svg>
                <div className="card-body">
                <p className="card-text">Zoo animals.</p>
                  <div className="d-flex justify-content-between align-items-center">
                    <div className="btn-group">
                      <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnimal()} className="btn btn-info">Display</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div className="col">
              <div className="card shadow-sm">
              <svg className="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false">
                <image href="../public/information.jpg" x="0" y="0" height="50px" width="50px"/>
              </svg>
              <div className="card-body">
                <p className="card-text">Zoo Information.</p>
                <div className="d-flex justify-content-between align-items-center">
                <div className="btn-group">
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
