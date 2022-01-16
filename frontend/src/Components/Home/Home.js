import React, { Component } from 'react';
import PostList from '../Post/PostList';

import Container from '@mui/material/Container';
import LeftMenu from '../Menu/LeftMenu';

import { Col, Row } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';




export default class Home extends Component {
    render() {
        return (
            <div>
                <Container>
                    <Row>
                        <Col><LeftMenu parentId={0} /></Col>
                        <Col><PostList /></Col>
                        <Col>3 of 3</Col>
                    </Row>
                </Container>
            </div>
        );
    }


}
