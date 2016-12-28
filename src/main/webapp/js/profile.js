function Tree(x, y, size, deviation, generations, minSplits, maxSplits) {
  this.x = x;
  this.y = y;
  this.size = size;
  this.deviation = deviation;
  this.minSplits = minSplits;
  this.maxSplits = maxSplits;
  this.generations = generations;
  this.jitter = deviation / 5;
  this.grow();
}
Tree.prototype = {
  constructor: Tree,
  grow: function () {
    this.layers = [];
    this.layers.push(this.makeBranch(-90, this.size, this.size / 10, 0));
    this.branch(this.layers[0]);
  },
  branch: function (pBranch) {
    if (pBranch.generation >= this.generations) {
      return;
    }
    var add = Math.ceil(pBranch.generation / 3),
      max = this.maxSplits + add,
      min = this.minSplits + add,
      len = Math.round(Math.random() * (max - min) + min),
      am = this.deviation / len;

    for (var i = 0; i < len; i++) {
      for (var j = 1; j <= 2; j++) {
        var length = pBranch.length * .66 / j + Math.random() * (this.jitter * 2) - this.jitter,
          angle = pBranch.angle + (Math.random() * this.deviation * 2) - this.deviation,
          width = (pBranch.generation < (this.generations / 2) ? pBranch.width * 1.33 : pBranch.width) * .45 / j,
          generation = pBranch.generation + j,
          newBranch = this.makeBranch(angle, length, width, generation);
        pBranch.children.push(newBranch);
        this.branch(newBranch);
      }
    }
    if (Math.random() < .88) {
      var angle = pBranch.angle + (Math.random() * this.deviation * 4) - this.deviation * 2,
        length = pBranch.length * .25 + Math.random() * (this.jitter * 2) - this.jitter,
        width = pBranch.width * .25,
        generation = pBranch.generation + 2,
        newBranch = this.makeBranch(angle, length, width, generation);
      pBranch.children.push(newBranch);
      this.branch(newBranch);
    }
  },
  render: function (context, wind) {
    this.renderBranch(this.layers[0], 0, 0, wind);
  },
  makeBranch: function (angle, length, width, generation) {
    return {
      angle: angle,
      length: length,
      width: width,
      generation: generation,
      children: []
    };
  },
  renderBranch: function (branch, x, y, w) {
    // this is ugly as shit
    var angle = typeof w === 'undefined' ? branch.angle : branch.angle + (w * Math.pow(branch.generation / this.generations), 3) + w * (branch.generation / this.generations);
    var rads = angle * (Math.PI / 180),
      endX = x + branch.length * Math.cos(rads),
      endY = y + branch.length * Math.sin(rads);
    context.beginPath();
    context.moveTo(this.x + x, this.y + y);
    context.lineTo(this.x + endX, this.y + endY);
    context.lineWidth = branch.width;
    context.stroke();
    context.closePath();
    for (var i = 0; i < branch.children.length; i++) {
      this.renderBranch(branch.children[i], endX, endY, w + .005);
    }
  }
};
var canvas = document.getElementById('canvas'),
  context = canvas.getContext('2d'),
  width, height, tree, wind, windfn = 'sin';

setTimeout(init, 100);

function init() {
  height = canvas.height = document.body.offsetHeight;
  width = canvas.width = document.body.offsetWidth;
  tree = new Tree(width / 2, height, height/6, 45, 5, 2, 4);
  wind = Math.random() * 12 - 6;
  render();
  update();
}

function update() {
  wind += Math[windfn](Date.now());
  if (wind > 32) {
    windfn = 'cos';
    wind = 32 - Math.random();
  }
  if (wind < -32) {
    windfn = 'sin';
    wind = -32 + Math.random();
  }
  setTimeout(update, 1000/30);
}

function render() {
  context.clearRect(0, 0, width, height);
  tree.render(context, wind);
  requestAnimationFrame(render);
}