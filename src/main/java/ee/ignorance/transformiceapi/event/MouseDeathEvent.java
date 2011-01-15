package ee.ignorance.transformiceapi.event;

public class MouseDeathEvent implements Event {

        private int mouseID;
        private String mouseName;

        public MouseDeathEvent(int mouseID, String mouseName) {
                setMouseID(mouseID);
                setMouseName(mouseName);
        }

        public int getMouseID() {
                return mouseID;
        }

        public void setMouseID(int mouseID) {
                this.mouseID = mouseID;
        }

        public String getMouseName() {
                return mouseName;
        }

        public void setMouseName(String mouseName) {
                this.mouseName = mouseName;
        }




}
