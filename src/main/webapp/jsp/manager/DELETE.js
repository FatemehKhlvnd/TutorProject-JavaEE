async function remove(id) {
    alert(id);
    const response = await fetch("/api/teacher/" + id, {
        method: "DELETE"
    });
    document.location.replace("/Manager-teacher-table.do")
}