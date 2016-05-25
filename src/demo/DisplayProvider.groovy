
package demo

import java.util.Random;

class DisplayProvider {
    Random random = new Random();
    def text = "Hello from Groovy!"
    
    int getGridInt(int x, int y){
        return grid[x-1][y-1]
    }
    
    def grid = [[0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]];
    
    void addRandomNumber(){
        int x = random.nextInt(4)
        int y = random.nextInt(4)
        while(grid[y][x] != 0){
            x = random.nextInt(4)
            y = random.nextInt(4)
        }
        int num = random.nextInt(2) + 1
        grid[y][x] = num
    }
    // pray forgiveness from the Groovy Gods
    // I hear they are forgiving, at least with semicolons
    Boolean move(String direction){
        if(!canMove(direction)){
            return false
        }
        if(direction.equals('l')){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    if(grid[i][j] == 0){
                        grid[i][j] = grid[i][j+1]
                        grid[i][j+1] = 0
                    }
                    if(grid[i][j] == grid[i][j+1]){
                        grid[i][j] ++
                        grid[i][j+1] = 0
                    }
                }
            }
        }
        else if(direction.equals('r')){
            for(int i = 0; i < 4; i++){
                for(int j = 2; j >= 0; j--){
                    if(grid[i][j] == 0){
                        grid[i][j] = grid[i][j-1]
                        grid[i][j-1] = 0
                    }
                    if(grid[i][j] == grid[i][j-1]){
                        grid[i][j] ++
                        grid[i][j-1] = 0
                    }
                }
            }
        }
        else if(direction.equals('u')){
            // probably need to rewrite in the form of
            // collapse empty cells
            // collapse duplicate cells
            // start from the top left corner
            for(int j = 0; j < 4; j++){
                // go down a row each time
                for(int i = 0; i < 3; i++){
                    //if the current cell is empty
                    if(grid[i][j] == 0){
                        // the current cell equals the contents of the next cell
                        grid[i][j] = grid[i+1][j]
                        // the next cell equals zero
                        grid[i+1][j] = 0
                    }
                    // if this cell equals the next vell
                    if(grid[i][j] == grid[i+1][j]){
                        // increment this cell
                        grid[i][j] ++
                        grid[i+1][j] = 0
                    }
                }
            }
        }
        else if(direction.equals('d')){
            for(int i = 0; i < 4; i++){
                for(int j = 2; j >= 0; j--){
                    if(grid[j][i] == 0){
                        grid[j][i] = grid[j][i-1]
                        grid[j][i-1] = 0
                    }
                    if(grid[j][i] == grid[j][i-1]){
                        grid[j][i] ++
                        grid[j][i-1] = 0
                    }
                }
            }
        }
        addRandomNumber();
    }
    
    // I am either structuring this very poorly
    // or this is just dumb for no reason
    // It really has to be the first one
    Boolean canMove(String direction){
        Boolean canMove = false;
        // things needed to be moveable
        // must either be a space or a collapsable block pair
        for(int i = 0; i < 4; i++){
            // Left
            if(direction.equals('l')){
                int previousNonZeroElement = 0
                Boolean firstNonZero = false
                Boolean space = false
                Boolean collapsible = false
                
                for(int j = 3; j >= 0; j--){
                    if(grid[i][j] != 0){
                        firstNonZero = true
                        previousNonZeroElement = grid[i][j]
                    }
                    if(firstNonZero){
                        if(grid[i][j] == 0){
                            space = true
                        }
                        if(previousNonZeroElement == grid[i][j]){
                            collapsible = true
                        }
                    }
                    
                }
                if(collapsible || space){
                    canMove = true
                    return true
                }
            }
            // Right
            else if(direction.equals('r')){
                int previousNonZeroElement = 0
                Boolean firstNonZero = false
                Boolean space = false
                Boolean collapsible = false
                
                for(int j = 0; j < 4; j++){
                    if(grid[i][j] != 0){
                        firstNonZero = true
                        previousNonZeroElement = grid[i][j]
                    }
                    if(firstNonZero){
                        if(grid[i][j] == 0){
                            space = true
                        }
                        if(previousNonZeroElement == grid[i][j]){
                            collapsible = true
                        }
                    }
                    
                }
                if(collapsible || space){
                    canMove = true
                    return true
                }
            }
            // Up
            else if(direction.equals('u')){
                int previousNonZeroElement = 0
                Boolean firstNonZero = false
                Boolean space = false
                Boolean collapsible = false
                
                for(int j = 3; j >= 0; j--){
                    if(grid[j][i] != 0){
                        firstNonZero = true
                        previousNonZeroElement = grid[j][i]
                    }
                    if(firstNonZero){
                        if(grid[j][i] == 0){
                            space = true
                        }
                        if(previousNonZeroElement == grid[j][i]){
                            collapsible = true
                        }
                    }
                    
                }
                if(collapsible || space){
                    canMove = true
                    return true
                }
            }
            // Down
            else if(direction.equals('d')){
                int previousNonZeroElement = 0
                Boolean firstNonZero = false
                Boolean space = false
                Boolean collapsible = false
                
                for(int j = 0; j < 4; j++){
                    if(grid[j][i] != 0){
                        firstNonZero = true
                        previousNonZeroElement = grid[j][i]
                    }
                    if(firstNonZero){
                        if(grid[j][i] == 0){
                            space = true
                        }
                        if(previousNonZeroElement == grid[j][i]){
                            collapsible = true
                        }
                    }
                    
                }
                if(collapsible || space){
                    canMove = true
                    return true
                }
            }
        }
        return canMove
    }

}

