import React, { Component } from 'react'

class HeaderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div><a href="/" className="navbar-brand">Zoo Management App</a></div>
                    <div><a href="/animals" className="navbar-brand">Animaux</a></div>
                    <div><a href="/infos" className="navbar-brand">Information</a></div>
                    </nav>
                </header>
            </div>
        )
    }
}

export default HeaderComponent
