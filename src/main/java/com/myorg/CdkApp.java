package com.myorg;

import software.amazon.awscdk.App;

public class CdkApp {
    public static void main(final String[] args) {

        App app = new App();

        VpcStack vpcStack = new VpcStack(app, "Vpc");
        
        ClusterStack clusterStack = new ClusterStack(app, "Cluster", vpcStack.getVpc());
        clusterStack.addDependency(vpcStack);

        Service01Stack service01Stack = new Service01Stack(app, "Service01", clusterStack.getCluster());
        service01Stack.addDependency(clusterStack);

        app.synth();

    }
}