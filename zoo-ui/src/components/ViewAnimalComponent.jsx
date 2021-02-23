import React, { Component } from 'react'
import AnimalService from '../services/AnimalService'

class ViewAnimalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            animal: {}
        }
    }

    componentDidMount(){
        AnimalService.getAnimalById(this.state.id).then( res => {
            this.setState({animal: res.data});
        })
    }

    back(){
        this.props.history.push('/animals');
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Animal Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <img className="card-img-top" src={this.state.animal.picture} alt="Pictre"/>
                        </div>
                        <br/><br/>
                        <div className = "row">
                            <label> Animal Name: </label>
                            <div> { this.state.animal.name }</div>
                        </div>
                        <br/><br/>
                        <div className = "row">
                            <label> Animal Latin Name: </label>
                            <div> { this.state.animal.latin_name }</div>
                        </div>
                        <br/><br/>
                        <div className = "row">
                            <label> Animal Description: </label>
                            <div> { this.state.animal.description }</div>
                        </div>
                    </div>
                    <button className="btn btn-danger" onClick={this.back.bind(this)} style={{marginLeft: "10px"}}>Back</button>
                </div>
            </div>
        )
    }
}

export default ViewAnimalComponent
