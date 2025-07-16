//
//  SystemInfoScreen.swift
//  iosApp
//
//  Created by Eslam El Meniawy on 13/07/2025.
//

import SwiftUI

struct SystemInfoScreen: View {
    var body: some View {
        NavigationStack {
            SystemInfoListView().navigationTitle("System Info")
        }
    }
}

#Preview {
    SystemInfoScreen()
}
