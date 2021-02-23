import React, { Component } from 'react'
import InfoService from '../services/InfoService'

class InfoComponent extends Component {
  constructor(props) {
      super(props)

      this.state = {
        info : {}
      }

  }

  componentDidMount(){
      InfoService.getAllInfos().then( res => {
          this.setState({info : res.data[0]});
          console.log(this.state.info);
      })
  }

  back(){
      this.props.history.push('/');
  }

  render() {
    return (

      <div>
          <div className = "card col-md-6 offset-md-3">
              <h3 className = "text-center"> {this.state.info.name}</h3>
              <div className = "card-body">
                  <br/><br/>
                  <div className = "row">
                    <p>{this.state.info.address}</p>
                    <p>{this.state.info.zip_code}</p>
                    <p>{this.state.info.street}</p>
                  </div>
                  <br/><br/>
                  <div className = "row">
                    <p>{this.state.info.access && this.state.info.access.id ? this.state.info.access.id : 'print something for missing id' }</p>
                  </div>
              </div>
              <button className="btn btn-danger" onClick={this.back.bind(this)} style={{marginLeft: "10px"}}>Back</button>
          </div>
      </div>
    );
  }
}
export default InfoComponent
