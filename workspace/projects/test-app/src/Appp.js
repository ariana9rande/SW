import PropTypes from 'prop-types'

function Potato()
{
  return (
    <div>
      <h1>I like potato</h1>
      <hr/>
    </div>
  )
}

function Movie(props)
{
  return (
    <div>
      <h1>I like {props.fav}</h1>
      <hr/>
    </div>
  )
}

function Food(props)
{
    return (
        <div>
            <h1>I like {props.name}</h1>
            <img src={props.image} alt={props.name}></img>
            <h1>rating : {props.rating}</h1>
        </div>
    );
}

const foodILike = 
[
  {
    id : 1,
    name : 'pizza',
    image : 'httpss://place-hold.it/200x150',
    rating : 5
  },
  {
    id : 2,
    name : 'orange',
    image : 'https://place-hold.it/200x150',
    rating : 4.9
  },
  {
    id : 3,
    name : 'ice cream',
    image : 'https://place-hold.it/200x150',
    rating : 4.2
  }
];

function App()
{
  return (
    <div>
      <h1>Hello</h1><hr/>
      <Potato />
      <Movie fav="steak"/>
      {foodILike.map((dish) =>
      {
        return <Food name = {dish.name} image = {dish.image} rating = {dish.rating} key = {dish.id}/>
      })}
    </div>
  );
}

Food.propTypes =
{
  name : PropTypes.string.isRequired,
  image : PropTypes.string.isRequired,
  rating : PropTypes.number.isRequired,
};

export default App;