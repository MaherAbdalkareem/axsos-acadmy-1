import React from 'react'
import {Link} from 'react-router-dom'
import TeamList from '../component/TeamList'
const Main = () => {
  return (
    <div>
        <h1>
            <Link to={'/player/list'}>List</Link> |
            <Link to={'/player/addplayer'}>Add player</Link>
        </h1>
        <TeamList/>
    </div>
  )
}

export default Main