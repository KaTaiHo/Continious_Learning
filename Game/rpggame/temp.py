# coding=utf-8

# imports the Pygame library
import pygame


def main():
    # initializes Pygame
    pygame.init()

    # sets the window title
    pygame.display.set_caption(u'FPS')

    # sets the window size
    pygame.display.set_mode((400, 400))

    # creates a 'Clock' object
    clock = pygame.time.Clock()

    # is the application running?
    is_running = True

    # if the application is running
    while is_running:
        # limits updates to 40 frames per second (FPS)
        dt1 = clock.tick(40)
        print (dt1)

        # gets events from the event queue
        for event in pygame.event.get():
            # if the 'close' button of the window is pressed
            if event.type == pygame.QUIT:
                # stops the application
                is_running = False

        # gets the number of milliseconds elapsed after the last tick
        dt2 = clock.get_time()
        print (dt2)

        # gets the number of frames per second (FPS)
        fps = clock.get_fps()
        print (fps)

    # finalizes Pygame
    pygame.quit()


if __name__ == '__main__':
    main()