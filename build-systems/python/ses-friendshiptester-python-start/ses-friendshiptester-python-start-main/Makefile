MAIN = app.py
TARGET = friendshiptester.bin

compile:
	@echo "compiling ..."
	pyinstaller --onefile --name $(TARGET) $(MAIN)
	@echo "Done compiling."

clean:
	@echo "cleaning ..."
	-rm -R ./build/*
	-rm -R ./dist/*
	@echo "Done cleaning."

test: 
	@echo "testing program $(MAIN) ...\n---------------"
	python3 $(MAIN)
	@echo "---------------\nProgram exited."

run: 
	@echo "testing program $(MAIN) ...\n---------------"
	@cd ./dist && ./$(TARGET)
	@echo "---------------\nProgram exited."