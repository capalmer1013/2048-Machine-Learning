
package demo

class DisplayProvider {

    def text = "Hello from Groovy!"
    def grid = [[0, 0, 0, 0]
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0]];
             
    Boolean move(String direction){
        if(direction.equals('l')){
            for(int i = 0; i < 4; i++){
                
            }
        }
        else if(direction.equals('r')){
            for(int i = 0; i < 4; i++){
                
            }
        }
        else if(direction.equals('u')){
            for(int i = 0; i < 4; i++){
                
            }
        }
        else if(direction.equals('d')){
            for(int i = 0; i < 4; i++){
                
            }
        }
    }
    
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
                
                for(int j = 3; j >= 0; i--){
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
                
                for(int j = 0; j < 4; i++){
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
                
                for(int j = 3; j >= 0; i++){
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
                
                for(int j = 0; j < 4; i++){
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

