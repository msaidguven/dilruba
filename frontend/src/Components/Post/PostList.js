import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";

function PostList() {

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
            <div>
                {postList.map(post => (
                    <p>
                        <Link to={{ pathname: '/post/' + post.id }}>
                            {post.postContent}
                        </Link>
                    </p>
                ))}
            </div>
        );
    }

}

export default PostList;