import React, {useState} from 'react';
import axios from "axios";
import {getFavorites, getUserId, setUserSession} from "./service/AuthService";

const Favorites = () => {

    const [storeId, setStoreId] = useState('');
    const favoritesUrl = 'https://rzfy99sz8c.execute-api.us-west-2.amazonaws.com/testing2/accounts/favorites';
    const favorites = JSON.stringify(getFavorites());

    const submitHandlerAdd = async (event) => {
        event.preventDefault();


        const data = {
            userId: getUserId(),
            storeId: storeId
        }


        try {
            let res = await axios({
                method: 'PUT',
                data: data,
                url: favoritesUrl,

            });
            if (res.status === 200) {
                setUserSession(res.data.accountModel.username, res.data.accountModel.userId, res.data.accountModel.email, res.data.accountModel.favorites);
                console.log(res);
                console.log(favorites);
                window.location.reload();

            }
        }
        catch (error) {

        }
    }

    const submitHandlerDelete = async (event) => {
        event.preventDefault();


        const data = {
            userId: getUserId(),
            storeId: storeId
        }

        try {
            let res = await axios({
                method: 'DELETE',
                data: data,
                url: favoritesUrl,

            });
            if (res.status === 200) {
                setUserSession(res.data.accountModel.username, res.data.accountModel.userId, res.data.accountModel.email, res.data.accountModel.favorites);
                console.log(res);
                window.location.reload();
            }
        }
        catch (error) {

        }
    }

    return (
        <div>
            <h5>Your Favorites</h5>
            <p>{favorites}</p>

            <form id="AddFavStore" onSubmit={submitHandlerAdd}>
                <h5>Favorites</h5>

                <p>Enter a store ID from the list to add to favorites list.</p>

                StoreId: <input type="text" value={storeId} onChange={event => setStoreId(event.target.value)} />

                <input type="submit" value="Add to Favorites"/>
            </form>
            <form id="DeleteFav" onSubmit={submitHandlerDelete}>
                <p>Enter a store ID from the list to delete from favorites list.</p>

                StoreId: <input type="text" value={storeId} onChange={event => setStoreId(event.target.value)} />

                <input type="submit" value="Delete from Favorites" />
            </form>

            <h5>Store IDs and Names</h5>
            <ul id="storelist">
                <li>z2fBI Abercrombie & Fitch</li>
                <li>GjcM4 American Eagle Outfitters</li>
                <li>FfYX7 Barnes & Noble</li>
                <li>iDrWm Bath & Body Works</li>
                <li>JnWs3 Foot Locker</li>
                <li>EOI7I GNC</li>
                <li>LtmPE Hollister</li>
                <li>hjL92 Journey's</li>
                <li>ELtmp Kay Jeweler's</li>
                <li>DXqRG L.A. Nails</li>
                <li>iqfPy Legacy Toys</li>
                <li>k8lhq Lids</li>
                <li>MLKcM Lovesac</li>
                <li>TjxBE Nike</li>
                <li>6qaUD Old Navy</li>
                <li>V3V9l Pandora</li>
                <li>6A5RH Piercing Pagoda</li>
                <li>61ofx Pink</li>
                <li>fvBKy Sephora</li>
                <li>6ASqS Sleep Number</li>
                <li>shlcx Spencer's</li>
                <li>td2LB T-Mobile</li>
                <li>M9pLu The Lego Store</li>
                <li>dW6KQ The North Face</li>
                <li>Wk8DZ Verizon</li>
                <li>vxG12 Yankee Candle</li>
                <li>fvaEr Zales</li>
            </ul>
        </div>
    )
}

export default Favorites;