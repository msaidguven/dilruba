import React, { useState, useEffect } from 'react';
import reactDom from 'react-dom';

import Button from '@mui/material/Button';

function Post() {

    const [error, serError] = useState(null);
    const [isLoaded, setLoaded] = useState(false);
    const [postList, setPostList] = useState([]);

    useEffect(() => {
        fetch("/posts")
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
            <ul>
                {postList.map(post => (
                    <li>
                        {post.postContent}
                    </li>
                ))}
            </ul>
        );
    }

}

export default Post;