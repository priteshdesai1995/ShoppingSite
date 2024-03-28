import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { addProductToCarousal } from '../../services/CarouselServices';


const AddCarouselProduct = () => {

    const [carousalType, setCarousalType] = useState('');
    const [url, setUrl] = useState('');
    const [path, setPath] = useState('');
    const [sourceType, setSourceType] = useState('');
    const navigator = useNavigate();

    const submitForm = (e) => {
        e.preventDefault();

        const employee = {carousalType, url, path, sourceType};
        console.log(employee);

        addProductToCarousal(employee).then((res) => {
            console.log(res.data);
        }).catch((e) => {
            console.error(e);
        })

        navigator("/home");
    }

    return (
        <div>
            <form>
                <div class="form-group">
                    <label for="carousalType">carousalType</label>
                    <input type="text" class="form-control" id="carousalType" aria-describedby="emailHelp" placeholder="Enter carousalType" name="carousalType"  
                    onChange={(e) => setCarousalType(e.target.value)}/>
                </div>
                <div class="form-group">
                    <label for="url">url</label>
                    <input type="text" class="form-control" id="url" aria-describedby="emailHelp" placeholder="Enter url" name="url" onChange={(e) => setUrl(e.target.value)}/>
                </div>
                <div class="form-group">
                    <label for="path">path</label>
                    <input type="text" class="form-control" id="path" aria-describedby="emailHelp" placeholder="Enter path" name="path" onChange={(e) => setPath(e.target.value)} />
                </div>
                <div class="form-group">
                    <label for="sourceType">sourceType</label>
                    <input type="text" class="form-control" id="sourceType" aria-describedby="emailHelp" placeholder="Enter sourceType" name="sourceType"
                     onChange={(e) => setSourceType(e.target.value)} />
                </div>
                <button type="submit" class="btn btn-primary" onClick={submitForm}>Submit</button>
            </form>
        </div>
    )
}

export default AddCarouselProduct;
