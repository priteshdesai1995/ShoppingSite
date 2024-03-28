import React, { useEffect, useState } from 'react';
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import { getAllProductCarousal } from '../../services/CarouselServices';



const MainCarousel = () => {


    const [carouselData, setCarouselData] = useState([]);

    useEffect(() => {
        getAllProductCarousal().then((res) => {
            console.log(res.data);
            setCarouselData(res.data);
        }).catch((e) => {
            console.error(e);
        });
    }, [])

    const items = carouselData.map((item) => <img className="cursor-pointer" role="presentation" src={item.url} alt="" />);


    return (
        <AliceCarousel
            mouseTracking
            items={items}
            controlsStrategy="alternate"
            autoPlay
            //disableButtonsControls
            autoPlayInterval={1000}
            infinite
            className="carosal"
            keyboardNavigation={true}
            renderPrevButton={() => {
                return <p className="p-4 absolute left-0 top-0">Previous Item</p>
            }}
            renderNextButton={() => {
                return <p className="p-4 absolute right-0 top-0">Next Item</p>
            }}
        />
    );
}
export default MainCarousel;