package json2.memdata;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import ru.gxfin.common.data.AbstractDataObject;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMemRepo<E extends AbstractDataObject> implements ObjectIdResolver {
    private final Map<Object, E> objects = new HashMap<>();

    @Override
    public void bindItem(ObjectIdGenerator.IdKey id, Object pojo) {
        final var old = this.objects.get(id.key);
        if (old != null) {
            if (old == pojo || (old != null && old.equals(pojo))) {
                return;
            }
            // TODO: Обновление объекта!
            throw new IllegalStateException("Already had POJO for id (" + id.key.getClass().getName() + ") [" + id + "]");
        }
        this.objects.put(id.key, (E)pojo);
    }

    @Override
    public E resolveId(ObjectIdGenerator.IdKey id) {
        return this.objects.get(id.key);
    }

    @Override
    public boolean canUseFor(ObjectIdResolver resolverType) {
        return resolverType.getClass() == getClass();
    }

    @Override
    public ObjectIdResolver newForDeserialization(Object context) {
        return this;
    }

}
