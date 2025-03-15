compile:
	mkdir -p build	
	javac -d build *.java model/*java

jar:
	jar cvfe build/app.jar App -C build .

run:
	java -jar build/app.jar

clean:
	rm -rf build