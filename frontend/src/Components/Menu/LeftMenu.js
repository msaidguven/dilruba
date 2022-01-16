import React, { useState, useEffect } from 'react';
import { useParams, Link } from "react-router-dom";
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Category from '../Category/Category';

function LeftMenu(props) {
    const {parentId} = props;

    const [error, serError] = useState(null);
    const [isLoaded, setLoaded] = useState(false);
    const [menuList, setMenuList] = useState([]);

    const [show, setShow] = useState(true);

    useEffect(() => {
        fetch("/menuler/" + parentId)
            .then(res => res.json())
            .then(
                (result) => {
                    setLoaded(true);
                    setMenuList(result)
                },
                (error) => {
                    setLoaded(true);
                    serError(error);
                }
            )
    }, [])
    if (error) {
        return <div>HATA!</div>;
    } else if (!isLoaded) {
        return <div>Loading...</div>;
    } else {
        return (
            <div>
                {menuList.map(menu => (
                    <Card>
                        <Link to={{ pathname: '/kpss/' + menu.menuSeflink }}>
                            {menu.menuName}
                        </Link>
                    </Card>
                ))}
                
            </div>
        );
    }
}
export default LeftMenu;