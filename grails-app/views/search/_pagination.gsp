<g:set var="cantMostrar" value="${cant != null ? cant : 5}"/>
<ul class="pagination" style="margin: 0px">
    <li aria-label="Previous">
        <button type="submit" class="btn-link" onclick="injectHiddenField('pageNumber', '${1}')">
            <a><span aria-hidden="true">«</span></a>
        </button>
    </li>
    <li aria-label="Previous">
        <button type="submit" class="btn-link" ${(pageActual - 1) > 0 ? '' : 'disabled=true'}
                onclick="injectHiddenField('pageNumber', '${pageActual - 1}')">
            <span aria-hidden="true"><</span>
        </button>
    </li>
    <g:each var="pagNumber"
            in="${pageActual > 5 ? ((pageActual-cantMostrar)..pageActual).toList() : (1..(pageActual)).toList()}">
        <g:if test="${pagNumber != pageActual}">
            <li>
                <button type="submit" class="btn-link" onclick="injectHiddenField('pageNumber', '${pagNumber}')">
                    <a>${pagNumber}</a>
                </button>
            </li>
        </g:if>
    </g:each>
    <li class="active"><button  disabled="true" class="btn-link">${pageActual}</button></li>
    <g:each var="pagNumber" in="${(pageActual+cantMostrar) <= pageCant ? ((pageActual+1)..(pageActual+cantMostrar)).toList() : ((pageActual)..(pageCant)).toList()}">
        <g:if test="${pagNumber != pageActual}">
            <li class="${pageActual == pagNumber ? 'active' : ''}">
                <button type="submit" class="btn-link" onclick="injectHiddenField('pageNumber', '${pagNumber}')">
                    <a>${pagNumber}</a>
                </button>
            </li>
        </g:if>
    </g:each>
    <li aria-label="Previous">
        <button type="submit" class="btn-link"
                onclick="injectHiddenField('pageNumber', '${pageActual + 1}')">
            <span aria-hidden="true">></span>
        </button>
    </li>
    <li aria-label="Previous" class="pull-right">
        <button type="submit" class="btn-link"
                onclick="injectHiddenField('pageNumber', '${pageCant}')">
            <span aria-hidden="true">»</span>
        </button>
    </li>
</ul>