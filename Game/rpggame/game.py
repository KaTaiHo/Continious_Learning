import pygame, sys
import window

class Game(object):
	
	def __init__(self):
		self.win = window.Window().create_window()
		self.isRunning = True
		self.clock = pygame.time.Clock()

	def show_fps(self):
		pygame.font.init()
		
		my_font = pygame.font.SysFont('Comic Sans MS', 20)
		fps_overlay = my_font.render(str(int(self.clock.get_fps())), True, (254,254,254))
		self.win.blit(fps_overlay, (0,0))


	def game_loop(self, debug = True):

		while self.isRunning:
			self.clock.tick(60)

			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.isRunning = False
					
			self.clock.get_time()
			self.win.fill((0, 0, 0))



			self.show_fps()
			pygame.display.update()

		pygame.quit()
		sys.exit()


	def run(self):
		self.game_loop()


if __name__ == "__main__":
	g = Game()
	g.run()



