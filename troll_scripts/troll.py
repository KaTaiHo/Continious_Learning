
def get_str():
	s = input('Enter your Meme:' )
	s = list(s)
	for i in range(len(s)):
		if i % 2 == 0:
			s[i] = s[i].upper()
	return ''.join(s)

if __name__ == "__main__":
	print (get_str())