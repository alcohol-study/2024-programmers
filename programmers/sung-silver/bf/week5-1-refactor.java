public int solution(int[][] sizes) {
        int answer = 0;
        int height = 0;
        int width = 0;

        for(int[] com : sizes){
            if(com[0]>com[1]){
                if(com[0]>height){
                    height = com[0];
                }
                if(com[1]>width){
                    width = com[1];
                }
            }
            else{
                if(com[1]>height){
                    height = com[1];
                }
                if(com[0]>width){
                    width = com[0];
                }
            }
        }

        answer = height * width;
        return answer;
    }
