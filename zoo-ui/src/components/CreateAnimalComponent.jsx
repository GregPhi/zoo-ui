import React, { Component } from 'react'
import AnimalService from '../services/AnimalService'

class CreateAnimalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            name: '',
            latin_name: '',
            description: ''
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeLatinNameHandler = this.changeLatinNameHandler.bind(this);
        this.saveOrUpdateAnimal = this.saveOrUpdateAnimal.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            AnimalService.getAnimalById(this.state.id).then( (res) =>{
                let animal = res.data;
                this.setState({
                    name: animal.name,
                    latin_name: animal.latin_name,
                    description : animal.description
                });
            });
        }
    }
    saveOrUpdateAnimal = (e) => {
        e.preventDefault();
        let animal = {name: this.state.name, latin_name: this.state.latin_name, description: this.state.description};
        console.log('animal => ' + JSON.stringify(animal));

        // step 5
        if(this.state.id === '_add'){
            AnimalService.createAnimal(animal).then(res =>{
                this.props.history.push('/animals');
            });
        }else{
            AnimalService.updateAnimal(this.state.id, animal).then( res => {
                this.props.history.push('/animals');
            });
        }
    }

    changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }

    changeLatinNameHandler= (event) => {
        this.setState({latin_name: event.target.value});
    }

    changeDescriptionHandler= (event) => {
        this.setState({description: event.target.value});
    }

    cancel(){
        this.props.history.push('/animals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Animal</h3>
        }else{
            return <h3 className="text-center">Update Animal</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Name: </label>
                                            <input placeholder="Name" name="name" className="form-control"
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Latin Name: </label>
                                            <input placeholder="Latin Name" name="latin_name" className="form-control"
                                                value={this.state.latin_name} onChange={this.changeLatinNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Description: </label>
                                            <input placeholder="Description" name="description" className="form-control"
                                                value={this.state.description} onChange={this.changeDescriptionHandler}/>
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateAnimal}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateAnimalComponent
