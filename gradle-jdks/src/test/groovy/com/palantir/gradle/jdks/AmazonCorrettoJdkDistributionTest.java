/*
 * (c) Copyright 2022 Palantir Technologies Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.gradle.jdks;

import static org.assertj.core.api.Assertions.assertThat;

import com.palantir.gradle.jdks.JdkPath.Extension;
import com.palantir.gradle.jdks.JdkRelease.Arch;
import org.junit.jupiter.api.Test;

class AmazonCorrettoJdkDistributionTest {
    private final AmazonCorrettoJdkDistribution distribution = new AmazonCorrettoJdkDistribution();

    @Test
    void jdk_path_linux_x86_64() {
        JdkPath path = distribution.path(JdkRelease.builder()
                .arch(Arch.X86_64)
                .os(Os.LINUX_GLIBC)
                .version("11.0.16.9.1")
                .build());
        assertThat(path.filename()).isEqualTo("downloads/resources/11.0.16.9.1/amazon-corretto-11.0.16.9.1-linux-x64");
        assertThat(path.extension()).isEqualTo(Extension.TARGZ);
    }

    @Test
    void jdk_path_macosx_aarch64() {
        JdkPath path = distribution.path(JdkRelease.builder()
                .arch(Arch.AARCH64)
                .os(Os.MACOS)
                .version("17.0.4.9.1")
                .build());
        assertThat(path.filename())
                .isEqualTo("downloads/resources/17.0.4.9.1/amazon-corretto-17.0.4.9.1-macosx-aarch64");
        assertThat(path.extension()).isEqualTo(Extension.TARGZ);
    }

    @Test
    void jdk_path_macosx_x64() {
        JdkPath path = distribution.path(JdkRelease.builder()
                .arch(Arch.X86_64)
                .os(Os.MACOS)
                .version("11.0.16.9.1")
                .build());
        assertThat(path.filename()).isEqualTo("downloads/resources/11.0.16.9.1/amazon-corretto-11.0.16.9.1-macosx-x64");
        assertThat(path.extension()).isEqualTo(Extension.TARGZ);
    }

    @Test
    void jdk_path_musl_linux_x64_64() {
        JdkPath path = distribution.path(JdkRelease.builder()
                .arch(Arch.X86_64)
                .os(Os.LINUX_MUSL)
                .version("11.0.16.9.1")
                .build());
        assertThat(path.filename())
                .isEqualTo("downloads/resources/11.0.16.9.1/amazon-corretto-11.0.16.9.1-alpine-linux-x64");
        assertThat(path.extension()).isEqualTo(Extension.TARGZ);
    }

    @Test
    void jdk_path_windows_x86_64() {
        JdkPath path = distribution.path(JdkRelease.builder()
                .arch(Arch.X86_64)
                .os(Os.WINDOWS)
                .version("17.0.4.9.1")
                .build());
        assertThat(path.filename())
                .isEqualTo("downloads/resources/17.0.4.9.1/amazon-corretto-17.0.4.9.1-windows-x64-jdk");
        assertThat(path.extension()).isEqualTo(Extension.ZIP);
    }
}
