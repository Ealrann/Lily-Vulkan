/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draw Indexed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getIndexCount <em>Index Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getFirstIndex <em>First Index</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getVertexOffset <em>Vertex Offset</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl#getFirstInstance <em>First Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DrawIndexedImpl extends MinimalEObjectImpl.Container implements DrawIndexed
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected int indexCount = INDEX_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCE_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getInstanceCount() <em>Instance Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceCount()
	 * @generated
	 * @ordered
	 */
	protected int instanceCount = INSTANCE_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstIndex() <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstIndex() <em>First Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstIndex()
	 * @generated
	 * @ordered
	 */
	protected int firstIndex = FIRST_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getVertexOffset() <em>Vertex Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexOffset()
	 * @generated
	 * @ordered
	 */
	protected static final int VERTEX_OFFSET_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVertexOffset() <em>Vertex Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexOffset()
	 * @generated
	 * @ordered
	 */
	protected int vertexOffset = VERTEX_OFFSET_EDEFAULT;

	/**
	 * The default value of the '{@link #getFirstInstance() <em>First Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstInstance()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_INSTANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstInstance() <em>First Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstInstance()
	 * @generated
	 * @ordered
	 */
	protected int firstInstance = FIRST_INSTANCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawIndexedImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicPackage.Literals.DRAW_INDEXED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled()
	{
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled)
	{
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIndexCount()
	{
		return indexCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexCount(int newIndexCount)
	{
		int oldIndexCount = indexCount;
		indexCount = newIndexCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__INDEX_COUNT, oldIndexCount, indexCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstanceCount()
	{
		return instanceCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstanceCount(int newInstanceCount)
	{
		int oldInstanceCount = instanceCount;
		instanceCount = newInstanceCount;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT, oldInstanceCount, instanceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFirstIndex()
	{
		return firstIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstIndex(int newFirstIndex)
	{
		int oldFirstIndex = firstIndex;
		firstIndex = newFirstIndex;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__FIRST_INDEX, oldFirstIndex, firstIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVertexOffset()
	{
		return vertexOffset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexOffset(int newVertexOffset)
	{
		int oldVertexOffset = vertexOffset;
		vertexOffset = newVertexOffset;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET, oldVertexOffset, vertexOffset));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFirstInstance()
	{
		return firstInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstInstance(int newFirstInstance)
	{
		int oldFirstInstance = firstInstance;
		firstInstance = newFirstInstance;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE, oldFirstInstance, firstInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
		case GraphicPackage.DRAW_INDEXED__NAME:
			return getName();
		case GraphicPackage.DRAW_INDEXED__ENABLED:
			return isEnabled();
		case GraphicPackage.DRAW_INDEXED__INDEX_COUNT:
			return getIndexCount();
		case GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT:
			return getInstanceCount();
		case GraphicPackage.DRAW_INDEXED__FIRST_INDEX:
			return getFirstIndex();
		case GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET:
			return getVertexOffset();
		case GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE:
			return getFirstInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
		case GraphicPackage.DRAW_INDEXED__NAME:
			setName((String) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__ENABLED:
			setEnabled((Boolean) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__INDEX_COUNT:
			setIndexCount((Integer) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT:
			setInstanceCount((Integer) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__FIRST_INDEX:
			setFirstIndex((Integer) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET:
			setVertexOffset((Integer) newValue);
			return;
		case GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE:
			setFirstInstance((Integer) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
		case GraphicPackage.DRAW_INDEXED__NAME:
			setName(NAME_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__ENABLED:
			setEnabled(ENABLED_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__INDEX_COUNT:
			setIndexCount(INDEX_COUNT_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT:
			setInstanceCount(INSTANCE_COUNT_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__FIRST_INDEX:
			setFirstIndex(FIRST_INDEX_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET:
			setVertexOffset(VERTEX_OFFSET_EDEFAULT);
			return;
		case GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE:
			setFirstInstance(FIRST_INSTANCE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
		case GraphicPackage.DRAW_INDEXED__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case GraphicPackage.DRAW_INDEXED__ENABLED:
			return enabled != ENABLED_EDEFAULT;
		case GraphicPackage.DRAW_INDEXED__INDEX_COUNT:
			return indexCount != INDEX_COUNT_EDEFAULT;
		case GraphicPackage.DRAW_INDEXED__INSTANCE_COUNT:
			return instanceCount != INSTANCE_COUNT_EDEFAULT;
		case GraphicPackage.DRAW_INDEXED__FIRST_INDEX:
			return firstIndex != FIRST_INDEX_EDEFAULT;
		case GraphicPackage.DRAW_INDEXED__VERTEX_OFFSET:
			return vertexOffset != VERTEX_OFFSET_EDEFAULT;
		case GraphicPackage.DRAW_INDEXED__FIRST_INSTANCE:
			return firstInstance != FIRST_INSTANCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", enabled: ");
		result.append(enabled);
		result.append(", indexCount: ");
		result.append(indexCount);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(", firstIndex: ");
		result.append(firstIndex);
		result.append(", vertexOffset: ");
		result.append(vertexOffset);
		result.append(", firstInstance: ");
		result.append(firstInstance);
		result.append(')');
		return result.toString();
	}

} //DrawIndexedImpl
