/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.CompositeBufferBarrier;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.vulkan.model.barrier.impl.AbstractBufferBarrierImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Composite Buffer Barrier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.CompositeBufferBarrierImpl#getDataProvider <em>Data Provider</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompositeBufferBarrierImpl extends AbstractBufferBarrierImpl implements CompositeBufferBarrier
{
	/**
	 * The default value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCE_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected int instance = INSTANCE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDataProvider() <em>Data Provider</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataProvider()
	 * @generated
	 * @ordered
	 */
	protected BufferDataProvider<?> dataProvider;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompositeBufferBarrierImpl()
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
		return ResourcePackage.Literals.COMPOSITE_BUFFER_BARRIER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getInstance()
	{
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance(int newInstance)
	{
		final int oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.COMPOSITE_BUFFER_BARRIER__INSTANCE, oldInstance, instance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BufferDataProvider<?> getDataProvider()
	{
		if (dataProvider != null && ((EObject)dataProvider).eIsProxy())
		{
			final InternalEObject oldDataProvider = (InternalEObject)dataProvider;
			dataProvider = (BufferDataProvider<?>)eResolveProxy(oldDataProvider);
			if (dataProvider != oldDataProvider)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER, oldDataProvider, dataProvider));
			}
		}
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BufferDataProvider<?> basicGetDataProvider()
	{
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDataProvider(BufferDataProvider<?> newDataProvider)
	{
		final BufferDataProvider<?> oldDataProvider = dataProvider;
		dataProvider = newDataProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER, oldDataProvider, dataProvider));
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
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__INSTANCE:
				return getInstance();
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER:
				if (resolve) return getDataProvider();
				return basicGetDataProvider();
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
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__INSTANCE:
				setInstance((Integer)newValue);
				return;
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider<?>)newValue);
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
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__INSTANCE:
				setInstance(INSTANCE_EDEFAULT);
				return;
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER:
				setDataProvider((BufferDataProvider<?>)null);
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
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__INSTANCE:
				return instance != INSTANCE_EDEFAULT;
			case ResourcePackage.COMPOSITE_BUFFER_BARRIER__DATA_PROVIDER:
				return dataProvider != null;
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

		final StringBuilder result = new StringBuilder(super.toString());
		result.append(" (instance: ");
		result.append(instance);
		result.append(')');
		return result.toString();
	}

} //CompositeBufferBarrierImpl
