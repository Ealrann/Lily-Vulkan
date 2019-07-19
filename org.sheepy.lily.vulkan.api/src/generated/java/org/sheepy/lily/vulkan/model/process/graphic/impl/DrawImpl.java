/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Draw</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#getVertexCount <em>Vertex Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#getInstanceCount <em>Instance Count</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#getFirstVertex <em>First Vertex</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl#getFirstInstance <em>First Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DrawImpl extends MinimalEObjectImpl.Container implements Draw
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
	 * The default value of the '{@link #getVertexCount() <em>Vertex Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexCount()
	 * @generated
	 * @ordered
	 */
	protected static final int VERTEX_COUNT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVertexCount() <em>Vertex Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexCount()
	 * @generated
	 * @ordered
	 */
	protected int vertexCount = VERTEX_COUNT_EDEFAULT;

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
	 * The default value of the '{@link #getFirstVertex() <em>First Vertex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstVertex()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_VERTEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstVertex() <em>First Vertex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstVertex()
	 * @generated
	 * @ordered
	 */
	protected int firstVertex = FIRST_VERTEX_EDEFAULT;

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
	public DrawImpl()
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
		return GraphicPackage.Literals.DRAW;
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__NAME, oldName, name));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getVertexCount()
	{
		return vertexCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVertexCount(int newVertexCount)
	{
		int oldVertexCount = vertexCount;
		vertexCount = newVertexCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__VERTEX_COUNT, oldVertexCount, vertexCount));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__INSTANCE_COUNT, oldInstanceCount, instanceCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFirstVertex()
	{
		return firstVertex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstVertex(int newFirstVertex)
	{
		int oldFirstVertex = firstVertex;
		firstVertex = newFirstVertex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__FIRST_VERTEX, oldFirstVertex, firstVertex));
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.DRAW__FIRST_INSTANCE, oldFirstInstance, firstInstance));
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
			case GraphicPackage.DRAW__NAME:
				return getName();
			case GraphicPackage.DRAW__ENABLED:
				return isEnabled();
			case GraphicPackage.DRAW__VERTEX_COUNT:
				return getVertexCount();
			case GraphicPackage.DRAW__INSTANCE_COUNT:
				return getInstanceCount();
			case GraphicPackage.DRAW__FIRST_VERTEX:
				return getFirstVertex();
			case GraphicPackage.DRAW__FIRST_INSTANCE:
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
			case GraphicPackage.DRAW__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.DRAW__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.DRAW__VERTEX_COUNT:
				setVertexCount((Integer)newValue);
				return;
			case GraphicPackage.DRAW__INSTANCE_COUNT:
				setInstanceCount((Integer)newValue);
				return;
			case GraphicPackage.DRAW__FIRST_VERTEX:
				setFirstVertex((Integer)newValue);
				return;
			case GraphicPackage.DRAW__FIRST_INSTANCE:
				setFirstInstance((Integer)newValue);
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
			case GraphicPackage.DRAW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.DRAW__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case GraphicPackage.DRAW__VERTEX_COUNT:
				setVertexCount(VERTEX_COUNT_EDEFAULT);
				return;
			case GraphicPackage.DRAW__INSTANCE_COUNT:
				setInstanceCount(INSTANCE_COUNT_EDEFAULT);
				return;
			case GraphicPackage.DRAW__FIRST_VERTEX:
				setFirstVertex(FIRST_VERTEX_EDEFAULT);
				return;
			case GraphicPackage.DRAW__FIRST_INSTANCE:
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
			case GraphicPackage.DRAW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.DRAW__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.DRAW__VERTEX_COUNT:
				return vertexCount != VERTEX_COUNT_EDEFAULT;
			case GraphicPackage.DRAW__INSTANCE_COUNT:
				return instanceCount != INSTANCE_COUNT_EDEFAULT;
			case GraphicPackage.DRAW__FIRST_VERTEX:
				return firstVertex != FIRST_VERTEX_EDEFAULT;
			case GraphicPackage.DRAW__FIRST_INSTANCE:
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
		result.append(", vertexCount: ");
		result.append(vertexCount);
		result.append(", instanceCount: ");
		result.append(instanceCount);
		result.append(", firstVertex: ");
		result.append(firstVertex);
		result.append(", firstInstance: ");
		result.append(firstInstance);
		result.append(')');
		return result.toString();
	}

} //DrawImpl
