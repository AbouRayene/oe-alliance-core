SUMMARY = "A fast JSON parser/generator for C++ with both SAX/DOM style API"
HOMEPAGE = "http://rapidjson.org/"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=ba04aa8f65de1396a7e59d1d746c2125"

SRC_URI = "git://github.com/miloyip/rapidjson.git;nobranch=1 \
           file://remove-march-native-from-CMAKE_CXX_FLAGS.patch \
           file://0001-CMakeLists.txt-fix-library-install-path.patch \
"

SRCREV = "e5635fb27feab7f6e8d7b916aa20ad799045a641"

PV = "1.1.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "-DRAPIDJSON_BUILD_DOC=OFF -DRAPIDJSON_BUILD_TESTS=OFF -DRAPIDJSON_BUILD_EXAMPLES=OFF -DBASE_LIB_PATH=${baselib}"

# RapidJSON is a header-only C++ library, so the main package will be empty.

FILES:${PN}-dev += "${libdir}/cmake"

BBCLASSEXTEND = "native nativesdk"
