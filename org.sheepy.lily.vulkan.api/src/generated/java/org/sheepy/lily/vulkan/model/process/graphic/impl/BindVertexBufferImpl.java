/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bind Vertex Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl#getFirstBinding <em>First Binding</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl#getVertexBindings <em>Vertex Bindings</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BindVertexBufferImpl extends MinimalEObjectImpl.Container implements BindVertexBuffer
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
	 * The default value of the '{@link #getFirstBinding() <em>First Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstBinding()
	 * @generated
	 * @ordered
	 */
	protected static final int FIRST_BINDING_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFirstBinding() <em>First Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstBinding()
	 * @generated
	 * @ordered
	 */
	protected int firstBinding = FIRST_BINDING_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVertexBindings() <em>Vertex Bindings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVertexBindings()
	 * @generated
	 * @ordered
	 */
	protected EList<VertexBinding> vertexBindings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindVertexBufferImpl()
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
		return GraphicPackage.Literals.BIND_VERTEX_BUFFER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_VERTEX_BUFFER__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_VERTEX_BUFFER__ENABLED, oldEnabled, enabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getFirstBinding()
	{
		return firstBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstBinding(int newFirstBinding)
	{
		int oldFirstBinding = firstBinding;
		firstBinding = newFirstBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.BIND_VERTEX_BUFFER__FIRST_BINDING, oldFirstBinding, firstBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<VertexBinding> getVertexBindings()
	{
		if (vertexBindings == null)
		{
			vertexBindings = new EObjectContainmentEList<VertexBinding>(VertexBinding.class, this, GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS);
		}
		return vertexBindings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS:
				return ((InternalEList<?>)getVertexBindings()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
			case GraphicPackage.BIND_VERTEX_BUFFER__NAME:
				return getName();
			case GraphicPackage.BIND_VERTEX_BUFFER__ENABLED:
				return isEnabled();
			case GraphicPackage.BIND_VERTEX_BUFFER__FIRST_BINDING:
				return getFirstBinding();
			case GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS:
				return getVertexBindings();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicPackage.BIND_VERTEX_BUFFER__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__ENABLED:
				setEnabled((Boolean)newValue);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__FIRST_BINDING:
				setFirstBinding((Integer)newValue);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS:
				getVertexBindings().clear();
				getVertexBindings().addAll((Collection<? extends VertexBinding>)newValue);
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
			case GraphicPackage.BIND_VERTEX_BUFFER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__FIRST_BINDING:
				setFirstBinding(FIRST_BINDING_EDEFAULT);
				return;
			case GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS:
				getVertexBindings().clear();
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
			case GraphicPackage.BIND_VERTEX_BUFFER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.BIND_VERTEX_BUFFER__ENABLED:
				return enabled != ENABLED_EDEFAULT;
			case GraphicPackage.BIND_VERTEX_BUFFER__FIRST_BINDING:
				return firstBinding != FIRST_BINDING_EDEFAULT;
			case GraphicPackage.BIND_VERTEX_BUFFER__VERTEX_BINDINGS:
				return vertexBindings != null && !vertexBindings.isEmpty();
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
		result.append(", firstBinding: ");
		result.append(firstBinding);
		result.append(')');
		return result.toString();
	}

} //BindVertexBufferImpl
