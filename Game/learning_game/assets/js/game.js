var game = new Phaser.Game(800, 600, Phaser.Auto)
var score = 0;
var scoreText;


var keyup, keydown, keyleft, keyright;

var GameState = {
	preload: function(){
		game.load.image('sky', 'assets/img/sky.png');
		game.load.image('ground', 'assets/img/platform.png');
		game.load.image('star', 'assets/img/star.png');
		game.load.spritesheet('dude', 'assets/img/dude.png', 32, 48);
	},
	create: function(){
		game.playerMap = {};
		
		//  We're going to be using physics, so enable the Arcade Physics system
		game.physics.startSystem(Phaser.Physics.ARCADE);

		//  A simple background for our game
		game.add.sprite(0, 0, 'sky');

		//  The platforms group contains the ground and the 2 ledges we can jump on
		platforms = game.add.group();

		//  We will enable physics for any object that is created in this group
		platforms.enableBody = true;

		// Here we create the ground.
		var ground = platforms.create(0, game.world.height - 64, 'ground');

		//  Scale it to fit the width of the game (the original sprite is 400x32 in size)
		ground.scale.setTo(2, 2);

		//  This stops it from falling away when you jump on it
		ground.body.immovable = true;

		//  Now let's create two ledges
		var ledge = platforms.create(400, 400, 'ground');

		ledge.body.immovable = true;

		ledge = platforms.create(-150, 250, 'ground');

		ledge.body.immovable = true;
		
		stars = game.add.group();

		stars.enableBody = true;

		//  Here we'll create 12 of them evenly spaced apart
		for (var i = 0; i < 12; i++)
		{
			//  Create a star inside of the 'stars' group
			var star = stars.create(i * 70, 0, 'star');

			//  Let gravity do its thing
			star.body.gravity.y = 6;

			//  This just gives each star a slightly random bounce value
			star.body.bounce.y = 0.7 + Math.random() * 0.2;
			
		}
		scoreText = game.add.text(16, 16, 'score: 0', { fontSize: '32px', fill: '#000' });

		keyup = game.input.keyboard.addKey(Phaser.Keyboard.UP);
		keydown = game.input.keyboard.addKey(Phaser.Keyboard.DOWN);
		keyleft = game.input.keyboard.addKey(Phaser.Keyboard.LEFT);
		keyright = game.input.keyboard.addKey(Phaser.Keyboard.RIGHT);

        keyup.onDown.add(game.echoMoveUp, this);
		keydown.onDown.add(game.echoMoveDown, this);
        keyleft.onDown.add(game.echoMoveLeft, this);
        keyright.onDown.add(game.echoMoveRight, this);

        keyup.onUp.add(game.echoStopMoving, this);
        keydown.onUp.add(game.echoStopMoving, this);
        keyleft.onUp.add(game.echoStopMoving, this);
        keyright.onUp.add(game.echoStopMoving, this);

		players = game.add.group();

		Client.askNewPlayer();
	},
	update: function() {
		game.physics.arcade.collide(stars, platforms);
		game.physics.arcade.collide(players, platforms);
        game.physics.arcade.overlap(players, stars, collectStar, null, this);
	}
}


function collectStar (player, star) {
    // Removes the star from the screen
    star.kill();
	
	//  Add and update the score
    score += 10;
    scoreText.text = 'Score: ' + score;

}

function addPhaserDude () {
    game.add.sprite(game.world.randomX, game.world.randomY, 'star');
}

game.addNewPlayer = function(id, x, y) {
	// The player and its settings
	// player = game.add.sprite(x, y, 'dude');
	var player = players.create(x, y, 'dude');

	//  We need to enable physics on the player
	game.physics.arcade.enable(player);

	//  Player physics properties. Give the little guy a slight bounce.
	player.body.bounce.y = 0.2;
	player.body.gravity.y = 300;
	player.body.collideWorldBounds = true;

	//  Our two animations, walking left and right.
	player.animations.add('left', [0, 1, 2, 3], 10, true);
	player.animations.add('right', [5, 6, 7, 8], 10, true);
	
	game.playerMap[id] = player;
	console.log("Adding new player with id: " + id);
};

game.removePlayer = function(id) {
	game.playerMap[id].destroy();
	delete game.playerMap[id];
};

game.echoMoveUp = function() {
	Client.socket.emit('moveUp');
};

game.echoMoveDown = function() {
    Client.socket.emit('moveDown');
};

game.echoMoveLeft = function() {
    Client.socket.emit('moveLeft');
};

game.echoMoveRight = function() {
    Client.socket.emit('moveRight');
};

game.echoStopMoving = function() {
	Client.socket.emit('stopMoving');
};

game.stopMoving = function(id) {
    var player = game.playerMap[id];
    player.body.velocity.x = 0;
    player.animations.stop();
	player.frame = 4;

}

game.movePlayerLeft = function(id) {
    var player = game.playerMap[id];
	player.body.velocity.x = 0;
    player.body.velocity.x = -150;
    player.animations.play('left');
};

game.movePlayerRight = function(id) {
	var player = game.playerMap[id];
    player.body.velocity.x = 0;
    player.body.velocity.x = 150;
    player.animations.play('right');
};

game.movePlayerUp = function(id) {
    var player = game.playerMap[id];
    // if (player.body.touching.down && player.hitPlatform)
    // {
        player.body.velocity.y = -350;
    // }
};

game.movePlayerDown = function(id) {
    var player = game.playerMap[id];


};

game.state.add('GameState', GameState);
game.state.start('GameState');
