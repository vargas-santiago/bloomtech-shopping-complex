import React from 'react';
import abercrombie from './storelogo/abercrombie150x150.png';
import ae from './storelogo/ae150x150.png';
import barnes from './storelogo/barnesnoble150x150.png';
import bathbody from './storelogo/bathbody150x150.png';
import footlocker from './storelogo/footlocker150x150.png';
import gamestop from './storelogo/gamestop150x150.png';
import gnc from './storelogo/gnc150x150.png';
import hollister from './storelogo/hollister150x150.png';
import journeys from './storelogo/journeys150x150.png';
import kay  from './storelogo/kay150x150.png';
import lanails from './storelogo/lanails150x150.png';
import legacy from './storelogo/legacy150x150.png';
import lego from './storelogo/lego150x150.png';
import lids from './storelogo/lids150x150.png';
import love from './storelogo/lovesac150x150.png';
import nike from './storelogo/nike150x150.png';
import northface from './storelogo/northface150x150.png';
import oldnavy from './storelogo/oldnavy150x150.png';
import pandora from './storelogo/pandora150x150.png';
import pierce from './storelogo/piercingpagoda150x150.png';
import pink from './storelogo/pink150x150.png';
import sephora from './storelogo/sephora150x150.png';
import sleep from './storelogo/sleepnumber150x150.png';
import spencers from './storelogo/spencers150x150.png';
import tmobile from './storelogo/tmobile150x150.png';
import verizon from './storelogo/verizon150x150.png';
import yankee from './storelogo/yankeecandle150x150.png';
import zales from './storelogo/zales150x150.png';

const Stores = () => {
    return (
        <div>
            <section className="stores">
                <h2>Stores</h2>
                <div className="grid">
                    <div className="item">
                        <h4 className="storeName">Abercrombie & Fitch</h4>
                        <img className="storeImg"
                             src={abercrombie}
                             alt="abercrombie logo" />
                            <p className="storeTag">women's apparel / men's apparel / children's apparel</p>
                            <a href="https://www.abercrombie.com/shop/us" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">American Eagle Outfitters</h4>
                        <img className="storeImg"
                             src={ae}
                             alt="american eagle logo" />
                            <p className="storeTag">women's apparel / men's apparel</p>
                            <a href="https://www.ae.com/us/en" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h3 className="storeName">Barnes & Noble</h3>
                        <img className="storeImg"
                             src={barnes}
                             alt="barnes and noble logo" />
                            <p className="storeTag">bookstore</p>
                            <a href="https://www.barnesandnoble.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Bath & Body Works</h4>
                        <img className="storeImg"
                             src={bathbody}
                             alt="bath and body works logo" />
                            <p className="storeTag">health and beauty</p>
                            <a href="https://www.bathandbodyworks.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Foot Locker</h4>
                        <img className="storeImg"
                             src={footlocker}
                             alt="foot locker logo" />
                            <p className="storeTag">shoes</p>
                            <a href="https://www.footlocker.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Gamestop</h4>
                        <img className="storeImg"
                             src={gamestop}
                             alt="gamestop logo" />
                        <p className="storeTag">electronics and tech</p>
                        <a href="https://www.gamestop.com/" target="_blank" rel="noreferrer">
                            <button className="btn">Visit this Store</button>
                        </a>
                        <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">General Nutrition Center</h4>
                        <img className="storeImg"
                             src={gnc}
                             alt="gnc logo" />
                            <p className="storeTag">health and beauty</p>
                            <a href="https://www.gnc.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Hollister</h4>
                        <img className="storeImg"
                             src={hollister}
                             alt="hollister logo" />
                            <p className="storeTag">women's apparel / men's apparel</p>
                            <a href="https://www.hollisterco.com/shop/us" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Journey's</h4>
                        <img className="storeImg"
                             src={journeys}
                             alt="journeys logo"/>
                            <p className="storeTag">shoes</p>
                            <a href="https://www.journeys.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Kay Jewelers</h4>
                        <img className="storeImg"
                             src={kay}
                             alt="kay's logo"/>
                            <p className="storeTag">jewelry</p>
                            <a href="https://www.kay.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">L.A. Nails</h4>
                        <img className="storeImg"
                             src={lanails}
                             alt="la nails logo"/>
                            <p className="storeTag">health and beauty</p>
                            <a href="https://www.lanailsbeauty.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Legacy Toys</h4>
                        <img className="storeImg"
                             src={legacy}
                             alt="legacy logo"/>
                            <p className="storeTag">toys, games, and hobbies</p>
                            <a href="https://www.legacytoys.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">The Lego Store</h4>
                        <img className="storeImg"
                             src={lego}
                             alt="lego logo"/>
                            <p className="storeTag">toys, games, and hobbies</p>
                            <a href="https://www.lego.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Lids</h4>
                        <img className="storeImg"
                             src={lids}
                             alt="lids logo"/>
                            <p className="storeTag">hats and accessories</p>
                            <a href="https://www.lids.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Lovesac</h4>
                        <img className="storeImg"
                             src={love}
                             alt="lovesac logo"/>
                            <p className="storeTag">furniture</p>
                            <a href="https://www.lovesac.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Nike</h4>
                        <img className="storeImg"
                             src={nike}
                             alt="nike logo"/>
                            <p className="storeTag">shoes</p>
                            <a href="https://www.nike.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">The North Face</h4>
                        <img className="storeImg"
                             src={northface}
                             alt="north face logo"/>
                            <p className="storeTag">women's apparel / men's apparel / children's apparel</p>
                            <a href="https://www.thenorthface.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Old Navy</h4>
                        <img className="storeImg"
                             src={oldnavy}
                             alt="old navy logo"/>
                            <p className="storeTag">women's apparel / men's apparel / children's apparel</p>
                            <a href="https://www.oldnavy.gap.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Pandora</h4>
                        <img className="storeImg"
                             src={pandora}
                             alt="pandora logo"/>
                            <p className="storeTag">jewelry</p>
                            <a href="https://www.pandora.net/en-ng" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Piercing Pagoda</h4>
                        <img className="storeImg"
                             src={pierce}
                             alt="piercing pagoda logo"/>
                            <p className="storeTag">jewelry</p>
                            <a href="https://www.banter.com/" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Pink</h4>
                        <img className="storeImg"
                             src={pink}
                             alt="pink logo"/>
                            <p className="storeTag">women's apparel</p>
                            <a href="https://www.victoriassecret.com/us/pink" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Sephora</h4>
                        <img className="storeImg"
                             src={sephora}
                             alt="sephora logo"/>
                            <p className="storeTag">health and beauty</p>
                            <a href="https://www.sephora.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Sleep Number</h4>
                        <img className="storeImg"
                             src={sleep}
                             alt="sleep number logo"/>
                            <p className="storeTag">furniture</p>
                            <a href="https://www.sleepnumber.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Spencers</h4>
                        <img className="storeImg"
                             src={spencers}
                             alt="spencers logo"/>
                            <p className="storeTag">home</p>
                            <a href="https://www.spencers.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">T-Mobile</h4>
                        <img className="storeImg"
                             src={tmobile}
                             alt="t-mobile logo"/>
                            <p className="storeTag">electronics and tech</p>
                            <a href="https://www.t-mobile.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Verizon</h4>
                        <img className="storeImg"
                             src={verizon}
                             alt="verizon logo"/>
                            <p className="storeTag">electronics and tech</p>
                            <a href="https://www.verizon.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Yankee Candle</h4>
                        <img className="storeImg"
                             src={yankee}
                             alt="yankee candle logo"/>
                            <p className="storeTag">home</p>
                            <a href="https://www.yankeecandle.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                    <div className="item">
                        <h4 className="storeName">Zales</h4>
                        <img className="storeImg"
                             src={zales}
                             alt="zales logo"/>
                            <p className="storeTag">jewelry</p>
                            <a href="https://www.zales.com" target="_blank" rel="noreferrer">
                                <button className="btn">Visit this Store</button>
                            </a>
                            <button className="favoritesButton">Add To Favorites</button>
                    </div>

                </div>
            </section>
        </div>
    )
}

export default Stores;