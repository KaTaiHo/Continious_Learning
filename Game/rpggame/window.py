import pygame, sys

pygame.init()

class Window(object):

	def __init__(self, height=600, width=800, title="Untitled"):
		self.window_width = width
		self.window_height = height
		self.window_title = title


	def create_window(self):
		pygame.display.set_caption(self.window_title)
		self.window = pygame.display.set_mode((self.window_width, self.window_height), pygame.HWSURFACE|pygame.DOUBLEBUF)
		return self.window


	def show_fps(self):
		pygame.font.init()
		my_font = pygame.font.SysFont('Comic Sans MS', 20)
		fps_overlay = my_font.render(str(pygame.time.Clock.get_fps()), True, (254,254,254))
		self.window.blit(fps_overlay, (0,0))
