import React, { useState, useEffect } from 'react';

import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

function User() {

    const [error, serError] = useState(null);
    const [isLoaded, setLoaded] = useState(false);
    const [postList, setPostList] = useState([]);

    useEffect(() => {
        fetch("/users")
            .then(res => res.json())
            .then(
                (result) => {
                    setLoaded(true);
                    setPostList(result)
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
                <Card sx={{ maxWidth: 345 }}>
                    <CardMedia
                        component="img"
                        height="140"
                        image="https://mui.com/static/images/cards/contemplative-reptile.jpg"
                        alt="green iguana"
                    />
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            Tarih - Kurtuluş Savaşı
                        </Typography>
                        <Typography variant="body2" color="text.secondary">
                            {postList.postContent}
                        </Typography>
                    </CardContent>
                    <CardActions>
                        <Button size="small">Share</Button>
                        <Button size="small">Learn More</Button>
                    </CardActions>
                </Card>

            </div>
        );
    }

}

export default User;

