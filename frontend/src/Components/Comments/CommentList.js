import React, { useState, useEffect } from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';

import { useParams } from "react-router-dom";

function CommentList() {
    const [error, serError] = useState(null);
    const [isLoaded, setLoaded] = useState(false);
    const [commentList, setCommentList] = useState([]);

    const { postId } = useParams();

    useEffect(() => {
        fetch("/comments?postId=" + postId)
            .then(res => res.json())
            .then(
                (result) => {
                    setLoaded(true);
                    setCommentList(result)
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

        if (!commentList) {
            return (
                <div>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            YORUMLAR
                        </Typography>
                    </CardContent>
                    <Card sx={{ maxWidth: 345 }}>
                        <CardContent>
                            <Typography variant="body2" color="text.secondary">
                                Yorum Bulunamadı
                            </Typography>
                        </CardContent>
                    </Card>
                </div>
            );
        } else {
            return (
                <div>
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            YORUMLAR
                        </Typography>
                    </CardContent>
                    {commentList.map(comment => (
                        <div>
                            <Card sx={{ maxWidth: 345 }}>
                                <CardContent>
                                    <Typography variant="body2" color="text.secondary">
                                        {comment.commentContent}
                                    </Typography>
                                </CardContent>
                            </Card>
                        </div>
                    ))}
                </div>
            );
        }

    }
}

export default CommentList;