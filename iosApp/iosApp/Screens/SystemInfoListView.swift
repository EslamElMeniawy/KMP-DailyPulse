//
//  SystemInfoListView.swift
//  iosApp
//
//  Created by Eslam El Meniawy on 13/07/2025.
//

import Shared
import SwiftUI

struct SystemInfoListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subtitle: String?
    }

    private let items: [RowItem] = {
        let systemInfo = SystemInfo()
        systemInfo.logSystemInfo()

        var result: [RowItem] = [
            .init(
                title: "Operating System",
                subtitle: [systemInfo.osName, systemInfo.osVersion].compactMap {
                    $0
                }.joined(separator: " ")
            ),
            .init(title: "Device", subtitle: systemInfo.deviceModel),
            .init(
                title: "Density",
                subtitle: {
                    if let density = systemInfo.density {
                        return "@\(density)x"
                    } else {
                        return nil
                    }
                }()
            ),
        ]

        return result
    }()

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote).foregroundStyle(.secondary)

                    Text(item.subtitle ?? "").font(.body).foregroundStyle(
                        .primary
                    )
                }.padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    SystemInfoListView()
}
