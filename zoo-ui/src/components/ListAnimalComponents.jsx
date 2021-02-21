import React, { Component } from 'react'
import AnimalService from '../services/AnimalService'

class ListAnimalComponents extends Component {
    constructor(props) {
        super(props)

        this.state = {
                animals: []
        }
        this.addAnimal = this.addAnimal.bind(this);
        this.editAnimal = this.editAnimal.bind(this);
        this.deleteAnimal = this.deleteAnimal.bind(this);
    }

    deleteAnimal(id){
        AnimalService.deleteAnimal(id).then( res => {
            this.setState({animals: this.state.animals.filter(animal => animal.id !== id)});
        });
    }
    viewAnimal(id){
        this.props.history.push(`/view-animal/${id}`);
    }
    editAnimal(id){
        this.props.history.push(`/add-animal/${id}`);
    }

    componentDidMount(){
        AnimalService.getAnimals().then((res) => {
            this.setState({ animals: res.data});
        });
    }

    addAnimal(){
        this.props.history.push('/add-animal/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Animals in Zoo</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addAnimal}>Create new animal</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Animal Picture</th>
                                    <th> Animal Name</th>
                                    <th> Animal Latin name</th>
                                    <th> Animal Description</th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.animals.map(
                                        animal =>
                                        <tr key = {animal.id}>
                                             <td> <img class="card-img-top" src={animal.picture} alt="Pictre"/> </td>
                                             <td> {animal.name} </td>
                                             <td> {animal.latin_name}</td>
                                             <td> {animal.description}</td>
                                             <td>
                                                 <button onClick={ () => this.editAnimal(animal.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAnimal(animal.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAnimal(animal.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListAnimalComponents
