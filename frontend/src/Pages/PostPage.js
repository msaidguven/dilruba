import React, { Component } from 'react';
import CommentList from '../Components/Comments/CommentList';
import SinglePost from '../Components/Post/SinglePost';


import Container from '@mui/material/Container';




export default class PostPage extends Component {
    render() {
        return (
            <div>
                <Container maxWidth="sm">
                    <SinglePost />

                    <CommentList />
                </Container>
            </div>
        );
    }


}
